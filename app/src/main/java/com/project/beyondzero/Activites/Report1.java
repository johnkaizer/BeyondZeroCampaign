package com.project.beyondzero.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.project.beyondzero.R;

public class Report1 extends AppCompatActivity {
    PDFView report1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);

        report1= findViewById(R.id.pdfView1);
        report1.fromAsset("doc1.pdf").load();
    }
}