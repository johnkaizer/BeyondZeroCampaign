package com.project.beyondzero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Report2 extends AppCompatActivity {
    PDFView report2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);

        report2= findViewById(R.id.pdfView2);
        report2.fromAsset("doc2.pdf").load();
    }
}