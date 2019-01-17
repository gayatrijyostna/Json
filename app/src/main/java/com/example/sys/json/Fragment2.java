package com.example.sys.json;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment2,container,false);
        RecyclerView recyclerView=view.findViewById( R.id.recyclerView );
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<JobListItem> jobListItems = new ArrayList<>();
     /*   List<JobListItem> jobListItems1 = new ArrayList<>();*/
        String json="{"+
                "\"Students\":["+
                        "{"+
                        "\"StudentName\" :\"MD.Asif\","+
                        "\"College\"      :\"Jayamukhi\","+
                        "\"Branch\"       :\"ECE\","+
                        "\"Rollno\"      :\"404\""+
                         "},{"+
                         "\"StudentName\" :\"Surya\","+
                         "\"College\"      :\"Jayamukhi\","+
                          "\"Branch\"       :\"ECE\","+
                         "\"Rollno\"      :\"406\""+
                         "},{"+
                        "\"StudentName\" :\"Thirupathi\","+
                        "\"College\"      :\"Jayamukhi\","+
                       "\"Branch\"       :\"ECE\","+
                         "\"Rollno\"      :\"444\""+
                       "},{"+
                       "\"StudentName\" :\"Ramesh\","+
                      "\"College\"      :\"Jayamukhi\","+
                       "\"Branch\"       :\"ECE\","+
                       "\"Rollno\"      :\"501\""+
                "}] }";
        try {
            JSONObject object= new JSONObject( json );
            JSONArray array=object.getJSONArray( "Students");

            for (int i=0;i<array.length();i++)
            {
                JobListItem item = new JobListItem();
                JSONObject list_obj = array.getJSONObject(i);
                item.setStudentName(list_obj.getString("StudentName"));
                item.setCollege(list_obj.getString("College"));
                item.setBranch(list_obj.getString("Branch"));
                item.setRollno(list_obj.getString("Rollno"));
                jobListItems.add( item );

            }
            recyclerView.setAdapter( new StudentAdapter( getActivity(),jobListItems ) );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }
}
