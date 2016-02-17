package se.oscarb.favoritethings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ListOfAnimalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_animals);


        // Vi behöver ett Zoo (det som skapar och levererar djur)
        Zoo myZoo = new Zoo();
        // myZoo.getNumberOfAnimals();


        // Hämta det som ska innehålla animal_card, d.v.s. vår card_container
        LinearLayout animalCardContainer = (LinearLayout) findViewById(R.id.card_container);

        // En LinearLayout är en ViewGroup   (LinearLayout extends ViewGroup)
        // En ViewGroup är en View           (ViewGroup extends View)

        // Hämta alla djur, ett djur i taget...
        for(int i = 0; i < myZoo.getNumberOfAnimals(); i++) {
            // Hämta ett visst djur
            Animal theAnimal = myZoo.getAnimal(i);

            // Hämta information om djuret
            String theAnimalName = theAnimal.getName();
            String theAnimalDescription = theAnimal.getDescription();
            int theAnimalImageId = theAnimal.getImageId();

            // Hämta XML-koden för ett kort och gör om till ett objekt i Java (inflate)
            View animalCard = getLayoutInflater().inflate(R.layout.animal_card, animalCardContainer, false);

            // Hämta Views inuti ett AnimalCard:
            TextView animalNameView = (TextView) animalCard.findViewById(R.id.animal_name);
            TextView animalDescriptionView = (TextView) animalCard.findViewById(R.id.animal_description);
            ImageView animalImageView = (ImageView) animalCard.findViewById(R.id.animal_image);

            // Ge varje knapp en tagg som motsvarar djurets namn med små bokstäver
            Button animalExploreButton = (Button) animalCard.findViewById(R.id.explore_button);
            animalExploreButton.setTag(theAnimalName.toLowerCase());

            // Ändra på ovan views så att de får informationen från djuren...
            animalNameView.setText(theAnimalName);
            animalDescriptionView.setText(theAnimalDescription);
            animalImageView.setImageResource(theAnimalImageId);

            // Lägg till i vår "container", d.v.s.
            animalCardContainer.addView(animalCard);
        }

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
