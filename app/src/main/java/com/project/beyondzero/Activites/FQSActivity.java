package com.project.beyondzero.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.beyondzero.R;

public class FQSActivity extends AppCompatActivity {
    TextView details,details1,details2,details3;
    LinearLayout layout,layout1,layout2,layout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fqsactivity);

        details = findViewById(R.id.changisha_details);
        layout = findViewById(R.id.linear);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        details1 = findViewById(R.id.changisha_details1);
        layout1 = findViewById(R.id.linear1);
        layout1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        details2 = findViewById(R.id.changisha_details2);
        layout2= findViewById(R.id.linear2);
        layout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        details3 = findViewById(R.id.changisha_details3);
        layout3= findViewById(R.id.linear3);
        layout3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
    }

    public void expand(View view) {
        int v = (details.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        details.setVisibility(v);
    }
    public void expand1(View view) {
        int v = (details1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        details1.setVisibility(v);
    }
    public void expand2(View view) {
        int v = (details2.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        details2.setVisibility(v);
    }
    public void expand3(View view) {
        int v = (details3.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        details3.setVisibility(v);
    }
}