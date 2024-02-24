package dev.lpa.Generics.challenge;

import java.util.ArrayList;
import java.util.List;

public class QueryList<T extends StudentType & QueryItem> extends ArrayList<T> {

    public QueryList() {
    }

    public QueryList(List<T> c) {
        super(c);
    }

    public QueryList<T> getMatches(String field, String value) {
        QueryList<T> matches = new QueryList<>();
        for (var item : this) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
