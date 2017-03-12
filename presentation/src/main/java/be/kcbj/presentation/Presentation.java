/*
    Copyright 2017 Litrik De Roy

    This file is part of KCBJ Sponsors.

    KCBJ Sponsors is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    KCBJ Sponsors is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with KCBJ Sponsors.  If not, see <http://www.gnu.org/licenses/>.

 */

package be.kcbj.presentation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringJoiner;

import be.kcbj.core.SponsorManager;
import be.kcbj.core.model.Sponsor;
import j2html.TagCreator;
import j2html.tags.ContainerTag;

public class Presentation {

    private static final int DELAY_IN_MILLIS = 0;

    private static final String DEST = "build/presentation/index.html";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new Presentation().generateHtml(file, SponsorManager.loadSponsors());
    }

    private void generateHtml(File output, List<Sponsor> sponsors) throws IOException {
        String htmlSnippet = new String(Files.readAllBytes(Paths.get("snippets/index.html")));
        FileWriter writer = new FileWriter(output);
        StringJoiner joiner = new StringJoiner("\n");
        for (int i = 0; i < sponsors.size(); i++) {
            Sponsor sponsor = sponsors.get(i);
            String sponsorString = generateSponsor(sponsor);
            joiner.add(sponsorString);
        }
        writer.write(htmlSnippet.replace("%s", joiner.toString()));
        writer.close();
    }

    private String generateSponsor(Sponsor sponsor) throws IOException {
        ContainerTag tag = TagCreator.section()
                .withData("background", "#069")
                .withData("autoslide", sponsor.isMajor() ? String.valueOf(DELAY_IN_MILLIS * 2) : String.valueOf(DELAY_IN_MILLIS));
        if (sponsor.image != null) {
            tag.with(TagCreator.img().withSrc("images/large/" + sponsor.image));
        }
        if (sponsor.name != null) {
            tag.with(TagCreator.h3().withText(sponsor.name));
        }
        if (sponsor.name2 != null) {
            tag.with(TagCreator.h3().withText(sponsor.name2));
        }
        if (sponsor.address != null) {
            tag.with(TagCreator.p().withText(sponsor.address));
        }
        if (sponsor.address2 != null) {
            tag.with(TagCreator.p().withText(sponsor.address2));
        }
        return tag.render();
    }

}
