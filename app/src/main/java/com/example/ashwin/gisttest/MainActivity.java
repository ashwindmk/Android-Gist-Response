package com.example.ashwin.gisttest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bluelinelabs.logansquare.LoganSquare;
import com.example.ashwin.gisttest.models.Employee;
import com.example.ashwin.gisttest.models.Employees;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private String mGistLink = "https://gist.githubusercontent.com/ashwindmk/7fc3da64a5aab125794cbd5e5b870add/raw/04cf93ce1bb83eaaf8b417d0d2c39a15b207f161/employees.json";
    private String mGistLink = "https://gist.githubusercontent.com/ashwindmk/7fc3da64a5aab125794cbd5e5b870add/raw/63fac3012d2580429d57c4891b21058e53a8b588/employees.json";
    private Employees mEmployees;
    private ArrayList<Employee> mEmployeesList;

    private TextView mContentTextView;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContentTextView = (TextView) findViewById(R.id.content_textview);

        getContent();
    }

    private void getContent() {
        RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();

        String url = mGistLink;

        StringRequest reasonsStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    mEmployees = LoganSquare.parse(response, Employees.class);
                    mEmployeesList = mEmployees.getEmployees();
                    String output = "";
                    for (Employee e : mEmployeesList) {
                        output += e.getName() + " (" + e.getAge() + ")\n\n";
                    }
                    mContentTextView.setText(output);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getActivity(), "Volley error " + error.networkResponse.statusCode, Toast.LENGTH_SHORT).show();
                //onReasonLoadFailed(error);
            }
        });

        reasonsStringRequest.setRetryPolicy(new DefaultRetryPolicy(15000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(reasonsStringRequest);
    }
}
