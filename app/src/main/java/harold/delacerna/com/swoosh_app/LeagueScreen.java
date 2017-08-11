package harold.delacerna.com.swoosh_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LeagueScreen extends AppCompatActivity {


    public static final String KEY_REPLY_MESSAGE = "key-sent-message";
    private static final int REQ_CODE = 1111;
    private Button btnMens, btnWomens, btnCoed, btnnext;
    private TextView message, messageHolder;
    String league;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_screen);
        findView();

    }

    private void findView() {
        btnMens = (Button) findViewById(R.id.btnFirst);
        btnWomens = (Button) findViewById(R.id.btnSec);
        btnCoed = (Button) findViewById(R.id.btnThird);
        btnnext = (Button) findViewById(R.id.btnNext);
        messageHolder = (TextView) findViewById(R.id.tMessageHolder);
        message = (TextView) findViewById(R.id.tMessage);
    }


    public void btn_MEN(View view) {
        if(btnMens.isEnabled() == true  ){
            btnnext.setEnabled(true);
            btnnext.setAlpha(0.8f);
            btnWomens.setAlpha(0.5f);
            btnCoed.setAlpha(0.5f);
            btnMens.setAlpha(0.8f);
            league = "men";
        }
        else{
            btnnext.setEnabled(false);
            btnnext.setAlpha(0.5f);
            btnWomens.setAlpha(0.8f);
            btnCoed.setAlpha(0.8f);
            btnMens.setAlpha(0.8f);
        }

    }

    public void btn_WOMENS(View view) {
        if(btnWomens.isEnabled() == true){
            btnnext.setEnabled(true);
            btnnext.setAlpha(0.8f);
            btnMens.setAlpha(0.5f);
            btnCoed.setAlpha(0.5f);
            btnWomens.setAlpha(0.8f);
            league = "women";
        }
        else{
            btnnext.setEnabled(false);
            btnnext.setAlpha(0.5f);
            btnMens.setAlpha(0.8f);
            btnCoed.setAlpha(0.8f);
            btnWomens.setAlpha(0.8f);
        }
    }

    public void btn_COED(View view) {
        if (btnCoed.isEnabled() == true) {
            btnnext.setEnabled(true);
            btnnext.setAlpha(0.8f);
            btnWomens.setAlpha(0.5f);
            btnMens.setAlpha(0.5f);
            btnCoed.setAlpha(0.8f);
            league = "coed";
        } else {
            btnnext.setEnabled(false);
            btnnext.setAlpha(0.5f);
            btnWomens.setAlpha(0.8f);
            btnMens.setAlpha(0.8f);
            btnCoed.setAlpha(0.8f);

        }
    }

    public void next(View view) {
        Intent i = new Intent(this, SkillScreen.class);
        startActivityForResult(i, REQ_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQ_CODE) {
                String replyMsg = data.getStringExtra(LeagueScreen.KEY_REPLY_MESSAGE);
                messageHolder.setVisibility(View.VISIBLE);
                message.setVisibility(View.VISIBLE);
                message.setText(replyMsg);
                btnnext.setVisibility(View.GONE);

                if(league.equals("men")){
                    btnWomens.setEnabled(false);
                    btnCoed.setEnabled(false);
                }
                else if(league.equals("women")){
                    btnMens.setEnabled(false);
                    btnCoed.setEnabled(false);
                }
                else if(league.equals("coed")){
                    btnMens.setEnabled(false);
                    btnWomens.setEnabled(false);
                }

            }
        }

    }

}
