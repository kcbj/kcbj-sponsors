package be.kcbj.core;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import be.kcbj.core.model.Sponsor;
import be.kcbj.core.model.Sponsors;

public class SponsorManager {

    private static final String BASEDIR = "../";

    public static List<Sponsor> loadSponsors() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(BASEDIR + "sponsors/sponsors.json"));
        Sponsors sponsors = new Gson().fromJson(reader, Sponsors.class);
        return sponsors.sponsors;
    }

    public static String getImageUrl(String name) {
        return BASEDIR + "sponsors/images/" + name;
    }
}
