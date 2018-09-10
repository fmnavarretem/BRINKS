package fmnavarretem.co.brinks.View.AppDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fmnavarretem.co.brinks.Model.POJO.App;
import fmnavarretem.co.brinks.R;
import fmnavarretem.co.brinks.Util.Constants;
import fmnavarretem.co.brinks.Util.JSONHelper;

public class AppDetail extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_detail);
        App app = (App) JSONHelper.objectFromJson(getIntent().getStringExtra(Constants.Intents.APP_DETAIL),App.class);
        setData(app);
    }

    private void setData(App app) {
        setTitle(app.getTitle().getLabel());
        Picasso.get().load(app.getImImage().get(2).getLabel()).into(((ImageView) findViewById(R.id.image)));
        ((TextView) findViewById(R.id.summary)).setText(app.getSummary().getLabel());
        ((TextView) findViewById(R.id.price)).setText(app.getImPrice().getLabel());
        ((TextView) findViewById(R.id.releaseDate)).setText(app.getImReleaseDate().getAttributes().getLabel());
        ((TextView) findViewById(R.id.category)).setText(app.getCategory().getAttributes().getLabel());
    }
}
