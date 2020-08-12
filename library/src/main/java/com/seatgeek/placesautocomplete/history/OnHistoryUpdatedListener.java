package com.seatgeek.placesautocomplete.history;

import androidx.annotation.NonNull;

import com.seatgeek.placesautocomplete.model.Place;

import java.util.List;

public interface OnHistoryUpdatedListener {
    public void onHistoryUpdated(@NonNull List<Place> updatedHistory);
}
