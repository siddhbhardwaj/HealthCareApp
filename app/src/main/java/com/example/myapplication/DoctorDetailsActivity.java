package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
    {
            {"Doctor Name: Dr Siddh Bhardwaj", "Hospital Address : Max Hospital, Saket", "Exp : 5yrs", "Mobile No: 8922334455", "600"},
            {"Doctor Name: Dr Rishit Upadhyay", "Hospital Address : Vedanta, Delhi", "Exp : 15yrs", "Mobile No: 8292234455", "900"},
            {"Doctor Name: Dr Prathmesh Sinha", "Hospital Address : AIIMS, Delhi", "Exp : 8yrs", "Mobile No: 7436562455", "300"},
            {"Doctor Name: Dr Baba", "Hospital Address : Jhol Hospital, DholakPur", "Exp : 6yrs", "Mobile No: 9182637209", "500"},
            {"Doctor Name: Dr Ankit Mishra", "Hospital Address : Mumbai City Hospital, Mumbai", "Exp : 7yrs", "Mobile No: 8252618992", "800"}

    };

    private String[][] doctor_details_2 =
            {
                    {"Doctor Name: Dr Jessica Lee", "Hospital Address : NewYork-Presbyterian, NY", "Exp : 10yrs", "Mobile No: 212-555-1212", "700"},
                    {"Doctor Name: Dr Samuel Kim", "Hospital Address : Cedars-Sinai Medical Center, CA", "Exp : 12yrs", "Mobile No: 310-555-1212", "750"},
                    {"Doctor Name: Dr John Smith", "Hospital Address : Mayo Clinic, MN", "Exp : 20yrs", "Mobile No: 507-555-1212", "1000"},
                    {"Doctor Name: Dr Emily Chen", "Hospital Address : Brigham and Women's Hospital, MA", "Exp : 8yrs", "Mobile No: 617-555-1212", "600"},
                    {"Doctor Name: Dr William Liu", "Hospital Address : Johns Hopkins Hospital, MD", "Exp : 15yrs", "Mobile No: 410-555-1212", "900"}
            };

    private String[][] doctor_details_3 =
            {
                    {"Doctor Name: Dr Daniel Lee", "Hospital Address : Massachusetts General Hospital, MA", "Exp : 14yrs", "Mobile No: 617-555-1212", "800"},
                    {"Doctor Name: Dr Mary Johnson", "Hospital Address : Stanford Health Care, CA", "Exp : 9yrs", "Mobile No: 650-555-1212", "650"},
                    {"Doctor Name: Dr David Kim", "Hospital Address : Ronald Reagan UCLA Medical Center, CA", "Exp : 18yrs", "Mobile No: 310-555-1212", "950"},
                    {"Doctor Name: Dr Rachel Wong", "Hospital Address : Cleveland Clinic, OH", "Exp : 7yrs", "Mobile No: 216-555-1212", "500"},
                    {"Doctor Name: Dr Jason Brown", "Hospital Address : Duke University Hospital, NC", "Exp : 13yrs", "Mobile No: 919-555-1212", "850"}
            };

    private String[][] doctor_details_4 =
            {
                    {"Doctor Name: Dr Lucy Martinez", "Hospital Address : University of California San Francisco Medical Center, CA", "Exp : 11yrs", "Mobile No: 415-555-1212", "750"},
                    {"Doctor Name: Dr Samuel Park", "Hospital Address : Mount Sinai Hospital, NY", "Exp : 16yrs", "Mobile No: 212-555-1212", "900"},
                    {"Doctor Name: Dr Elizabeth Lee", "Hospital Address : Barnes-Jewish Hospital, MO", "Exp : 19yrs", "Mobile No: 314-555-1212", "1000"},
                    {"Doctor Name: Dr Michael Brown", "Hospital Address : Emory University Hospital, GA", "Exp : 12yrs", "Mobile No: 404-555-1212", "700"},
                    {"Doctor Name: Dr Sarah Nguyen", "Hospital Address : Northwestern Memorial Hospital, IL", "Exp : 8yrs", "Mobile No: 312-555-1212", "600"}
            };
    private String[][] doctor_details_5 = {
            {"Doctor Name: Dr Ashok Sharma", "Hospital Address: Fortis Hospital, Noida", "Exp: 12yrs", "Mobile No: 8888888888", "700"},
            {"Doctor Name: Dr Rajesh Gupta", "Hospital Address: Apollo Hospital, Delhi", "Exp: 9yrs", "Mobile No: 7777777777", "1000"},
            {"Doctor Name: Dr Sushil Kumar", "Hospital Address: Medanta Hospital, Gurgaon", "Exp: 6yrs", "Mobile No: 6666666666", "400"},
            {"Doctor Name: Dr Priya Sharma", "Hospital Address: Max Hospital, Noida", "Exp: 3yrs", "Mobile No: 5555555555", "300"},
            {"Doctor Name: Dr Rohit Singh", "Hospital Address: AIIMS, Patna", "Exp: 4yrs", "Mobile No: 4444444444", "600"}
    };


    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String > item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv= findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.ButtonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details_2;
        else if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details_3;
        else if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details_4;
        else
            doctor_details=doctor_details_5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
         list = new ArrayList();
         for(int i =0;i<doctor_details.length;i++){
             item = new HashMap<String,String>();
             item.put("line1", doctor_details[i][0]);
             item.put("line2", doctor_details[i][1]);
             item.put("line3", doctor_details[i][2]);
             item.put("line4", doctor_details[i][3]);
             item.put("line5", "Cons Fee: " +doctor_details[i][4] + "/-");
             list.add(item);

         }
         sa = new SimpleAdapter(this,list,
                 R.layout.multi_lines,
                 new String[]{"line1","line2","line3","line4","line5"},
                 new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                 );
        ListView lst = findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view, int i, long l){
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);


            }
        });
    }
}