package se.oscarb.favoritethings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailedInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_information);

        // Hämta våra views från vår layoutfil
        ImageView animalPortrait = (ImageView) findViewById(R.id.animal_portrait);
        TextView animalHeadline = (TextView) findViewById(R.id.animal_headline);
        TextView animalDescription = (TextView) findViewById(R.id.animal_description);

        // Vilket djur ska vi visa upp?
        Intent intent = getIntent();
        String animalToDisplay = intent.getStringExtra("animal");

        // Skapa ett Zoo (som i sin tur skapar djur)
        Zoo theZoo = new Zoo();

        // Hämta ut ett djur
        Animal animal = theZoo.getAnimal(animalToDisplay);

        if(animal != null) {

            // Ända texten ovanpå bilden
            animalHeadline.setText(animal.getName());

            // Ändra animalDescription
            animalDescription.setText(animal.getDescription());

            // Ändra animalPortrait, hur?
            animalPortrait.setImageResource(animal.getImageId());

        }
    }
}
