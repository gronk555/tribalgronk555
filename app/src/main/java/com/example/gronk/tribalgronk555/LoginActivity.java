package com.example.gronk.tribalgronk555;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;



public class LoginActivity extends Activity {
    private TwitterLoginButton loginButton;
    private TextView status;
    private EditText query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        loginButton = (TwitterLoginButton)findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new LoginHandler());
        status = (TextView)findViewById(R.id.status);
        status.setText("Status: click login button");
        query = (EditText)findViewById(R.id.keyword);
        query.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId == EditorInfo.IME_ACTION_DONE) || ((event.getKeyCode() == KeyEvent.KEYCODE_ENTER) && (event.getAction() == KeyEvent.ACTION_DOWN))) {
                    Intent intent = new Intent(LoginActivity.this, ResultActivity.class);
                    intent.putExtra("query", query.getText().toString());
                    startActivity(intent);
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,  resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

    private class LoginHandler extends Callback<TwitterSession>{
        @Override
        public void success(Result<TwitterSession> twitterSessionResult){
            String output = "Status: login successful ";
            status.setText(output);
        }
        @Override
        public void failure(TwitterException e){
            status.setText("Status: Login failed");
        }
    }


}
