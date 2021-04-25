package iek.agdimitr.lab_buttons;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int points=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void addPoints(View view){
        points++;
        Log.d("points", ""+points);
        changePointsText(view);
        changeTitle(view);

    }

    public void removePoints(View view){
        points--;
        Log.d("points", ""+points);
        changePointsText(view);
        changeTitle(view);
    }


    public void changePointsText(View v){

        //πρώτα δηλώνω και αρχικοποιώ μία παράμετρο του τύπου που θέλω
        // εδώ η παράμετρος πρέπει να είναι TextView
        TextView pointsView = findViewById(R.id.textViewPoints);

        if (points>0){
            pointsView.setVisibility(View.VISIBLE);
            pointsView.setText(""+points);
            pointsView.setTextSize(44);
            pointsView.setTextColor(getResources().getColor(R.color.pointsWinnerColor));
            } else {
            if (points<0){
                pointsView.setVisibility(View.VISIBLE);
                pointsView.setText(""+points);
                pointsView.setTextSize(44);
                pointsView.setTextColor(getResources().getColor(R.color.pointsLooserColor));
       } else {
                pointsView.setVisibility(View.INVISIBLE);
            }
        }

    }

    public void changeTitle(View v){
        TextView title = findViewById(R.id.textViewTitle);
        TextView score = findViewById(R.id.textViewPoints);

        if (score.getCurrentTextColor()==getResources().getColor(R.color.pointsWinnerColor)){
            title.setVisibility(View.VISIBLE);
            title.setText(R.string.winTitle);
            title.setTextSize(44);
            title.setTextColor(getResources().getColor(R.color.pointsWinnerColor));
        } else {
            if (score.getCurrentTextColor()==getResources().getColor(R.color.pointsLooserColor)){
                title.setVisibility(View.VISIBLE);
                title.setText(R.string.looseTitle);
                title.setTextSize(44);
                title.setTextColor(getResources().getColor(R.color.pointsLooserColor));
            }

        }
        if(score.getVisibility()==View.INVISIBLE){
            title.setVisibility(View.VISIBLE);
            title.setText(R.string.drawTitle);
            title.setTextSize(44);

        }

      /*  if (points>0){
         title.setVisibility(View.VISIBLE);
            title.setText("ΚΕΡΔΑΜΕ");
            title.setTextSize(44);
            title.setTextColor(getResources().getColor(R.color.pointsWinnerColor));
        }else {
            if (points<0){
                title.setVisibility(View.VISIBLE);
                title.setText("ΧΑΝΟΥΜΕ");
                title.setTextSize(44);
                title.setTextColor(getResources().getColor(R.color.pointsLooserColor));
            } else {
                title.setText(R.string.Title);
            }
        } */
    }

}