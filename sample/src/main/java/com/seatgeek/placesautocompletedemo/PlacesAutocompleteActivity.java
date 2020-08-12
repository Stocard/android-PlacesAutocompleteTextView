package com.seatgeek.placesautocompletedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.seatgeek.placesautocomplete.DetailsCallback;
import com.seatgeek.placesautocomplete.OnPlaceSelectedListener;
import com.seatgeek.placesautocomplete.PlacesAutocompleteTextView;
import com.seatgeek.placesautocomplete.model.AddressComponent;
import com.seatgeek.placesautocomplete.model.AddressComponentType;
import com.seatgeek.placesautocomplete.model.Place;
import com.seatgeek.placesautocomplete.model.PlaceDetails;

public class PlacesAutocompleteActivity extends Activity {

    private PlacesAutocompleteTextView autocompleteTextView;
    private TextView streetTextView;
    private TextView cityTextView;
    private TextView stateTextView;
    private TextView zipTextView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_autocomplete);

        autocompleteTextView = findViewById(R.id.autocomplete);
        streetTextView = findViewById(R.id.street);
        cityTextView = findViewById(R.id.city);
        stateTextView = findViewById(R.id.state);
        zipTextView = findViewById(R.id.zip);

        autocompleteTextView.setOnPlaceSelectedListener(new OnPlaceSelectedListener() {
            @Override
            public void onPlaceSelected(final Place place) {
                autocompleteTextView.getDetailsFor(place, new DetailsCallback() {
                    @Override
                    public void onSuccess(final PlaceDetails details) {
                        Log.d("test", "details " + details);
                        streetTextView.setText(details.name);
                        for (AddressComponent component : details.address_components) {
                            for (AddressComponentType type : component.types) {
                                switch (type) {
                                    case STREET_NUMBER:
                                        break;
                                    case ROUTE:
                                        break;
                                    case NEIGHBORHOOD:
                                        break;
                                    case SUBLOCALITY_LEVEL_1:
                                        break;
                                    case SUBLOCALITY:
                                        break;
                                    case LOCALITY:
                                        cityTextView.setText(component.long_name);
                                        break;
                                    case ADMINISTRATIVE_AREA_LEVEL_1:
                                        stateTextView.setText(component.short_name);
                                        break;
                                    case ADMINISTRATIVE_AREA_LEVEL_2:
                                        break;
                                    case COUNTRY:
                                        break;
                                    case POSTAL_CODE:
                                        zipTextView.setText(component.long_name);
                                        break;
                                    case POLITICAL:
                                        break;
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(final Throwable failure) {
                        Log.d("test", "failure " + failure);
                    }
                });
            }
        });
    }
}
