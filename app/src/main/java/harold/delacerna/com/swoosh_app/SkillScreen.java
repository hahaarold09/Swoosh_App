package harold.delacerna.com.swoosh_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SkillScreen extends AppCompatActivity {

    Intent data = new Intent();
    String skill;
    private Button btnFirst, btnSec, btnfinish;
    public static final String KEY_SEND_MESSAGE = "key-sent-message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_screen);
        findView();


    }

    private void findView() {

        btnfinish = (Button) findViewById(R.id.btnFinish);
        btnSec = (Button) findViewById(R.id.btnBaller);
        btnFirst = (Button) findViewById(R.id.btnBeginner);

    }

    public void Beginner(View view) {

        btnfinish.setText("Finish");
        btnfinish.setEnabled(true);
        skill = "Beginner";
        btnfinish.setVisibility(View.VISIBLE);

    }

    public void Baller(View view) {
        btnfinish.setEnabled(true);
        btnfinish.setText("Finish");
        skill = "Baller";
        btnfinish.setVisibility(View.VISIBLE);
    }


    public void finish(View view) {
        String skillMessage = "";
        if(skill.equals("Beginner")){
            skillMessage = btnFirst.getText().toString();

        }
        else if (skill.equals("Baller")){
            skillMessage = btnSec.getText().toString();

        }
        data.putExtra(KEY_SEND_MESSAGE, skillMessage);
        setResult(Activity.RESULT_OK, data);
        finish();

    }




}


