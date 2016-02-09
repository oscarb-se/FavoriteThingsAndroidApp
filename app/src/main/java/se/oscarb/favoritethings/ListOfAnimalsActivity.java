package se.oscarb.favoritethings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ListOfAnimalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_animals);

        // Lägg till saker med programmering!
        TextView dummyTextView = new TextView(this);
        dummyTextView.setText("Dummy text");

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_container);
        linearLayout.addView(dummyTextView);

    }




    // Instansmetoder

    // Vad som händer när man klickar på knappen "EXPLORE"
    public void exploreAnimal(View view) {

        // Vilken knapp klickade vi på?
        String tag = (String) view.getTag();

        Toast.makeText(this, "Knappens tag är " + tag, Toast.LENGTH_SHORT).show();


        // Starta vår activity DetailedInformationActivity
        Intent intent = new Intent(this, DetailedInformationActivity.class);

                        // key    // value
        intent.putExtra("animal", tag);




        startActivity(intent);
    }


    // Vad som händer när man klickar på "SHARE"
    public void shareInformation(View view) {

        // Visa upp en "Toast" med att vi klickat på knappen...
        Toast.makeText(this, "Klickade på knappen!", Toast.LENGTH_LONG).show();

        // Skapa en implicit intent
        // D.v.s. skicka information som kan tas emot av en annan app
        Intent intent = new Intent();
        // Vad vill vi göra? Skicka text
        intent.setAction(Intent.ACTION_SEND);
        // Vilken text vill vi skicka?
        intent.putExtra(Intent.EXTRA_TEXT, "Red Panda är en björn");
        // Vad är det för något vi skickar?
        intent.setType("text/plain");

        // Skicka!
        // startActivity(intent);

        Zoo myZoo = new Zoo();
        Animal elk = myZoo.getAnimal("elk");
        if(elk != null) {
            String elkName = elk.getName();
            Toast.makeText(this, "Älgen heter " + elkName, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Det finns ingen älg!  ", Toast.LENGTH_SHORT).show();
        }






    }

}
