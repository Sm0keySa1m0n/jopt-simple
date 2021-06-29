/*
 The MIT License

 Copyright (c) 2004-2021 Paul R. Holser, Jr.

 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
 the following conditions:

 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package tests.joptsimple;

import static java.util.Arrays.*;
import static java.util.Collections.*;

import joptsimple.OptionSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:pholser@alumni.rice.edu">Paul Holser</a>
 */
public class OptionSynonymNoArgumentTest extends AbstractOptionParserFixture {
    @Before
    public final void initializeParser() {
        parser.acceptsAll( asList( "N", "after-date", "newer" ) );
    }

    @Test
    public void hasAllSynonymsWhenFirstSynonymParsed() {
        assertDetections( "-N" );
    }

    @Test
    public void hasAllSynonymsWhenSecondSynonymParsed() {
        assertDetections( "--after-d" );
    }

    @Test
    public void hasAllSynonymsWhenThirdSynonymParsed() {
        assertDetections( "--n" );
    }

    private void assertDetections( String option ) {
        OptionSet options = parser.parse( option );

        assertOptionDetected( options, "N" );
        assertOptionDetected( options, "after-date" );
        assertOptionDetected( options, "newer" );
        assertEquals( emptyList(), options.valuesOf( "N" ) );
        assertEquals( emptyList(), options.valuesOf( "after-date" ) );
        assertEquals( emptyList(), options.valuesOf( "newer" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }
}
