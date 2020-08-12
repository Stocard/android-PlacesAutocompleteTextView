package com.seatgeek.placesautocomplete.util;

import android.location.Location;
import androidx.annotation.NonNull;

public final class LocationUtils {

    public static String toLatLngString(@NonNull Location location) {
        return location.getLatitude() + "," + location.getLongitude();
    }

    private LocationUtils() {
    }
}
