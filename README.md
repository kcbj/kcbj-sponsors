
# KCBJ Sponsors

*KCBJ Sponsors* is a small program of korfballclub [KCBJ](http://www.kcbj.be/) to:
 1. generate an A4 PDF with the sponsors
 1. generate an HTML presentation with the sponsors

## How to use?

1. Clone the repo with the `--recursive` parameter, e.g. `git clone --recursive git@github.com:kcbj/kcbj-sponsors.git`
2. Execute `cd kcbj-sponsors`
3. Update sponsors in [`sponsors/sponsors.json`](https://github.com/litrik/kcbj-sponsors/blob/master/sponsors/sponsors.json).
4. Execute `./gradlew run`
5. The PDF file is generated in `placemat/build/placemat.pdf`
6. The HTML presentation is generated in `presentation/build/presentation`

## License

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