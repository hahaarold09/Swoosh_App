package harold.delacerna.com.swoosh_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {

    Button btnstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        btnstart = (Button) findViewById(R.id.btnGETSTART);
    }

    public void getStarted(View view) {

        Intent i = new Intent(this, LeagueScreen.class);
        startActivity(i);

    }


}
