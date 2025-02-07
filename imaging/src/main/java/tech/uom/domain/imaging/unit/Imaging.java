/*
 * Domain Specific Units of Measurement Extensions
 * Copyright (c) 2018-2025, Units of Measurement
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of Unit-API, Units of Measurement nor the names of their contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package tech.uom.domain.imaging.unit;

import static systems.uom.unicode.CLDR.BYTE;
import static systems.uom.unicode.CLDR.INCH;
import static tech.units.indriya.AbstractUnit.ONE;
import static tech.units.indriya.unit.Units.METRE;
import static tech.units.indriya.unit.Units.SECOND;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Frequency;
import javax.measure.quantity.Length;
import javax.measure.spi.SystemOfUnits;

import systems.uom.quantity.Information;
import systems.uom.quantity.Resolution;
import tech.units.indriya.AbstractSystemOfUnits;
import tech.units.indriya.AbstractUnit;
import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.unit.ProductUnit;

/**
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.6
 */
public class Imaging extends AbstractSystemOfUnits {

	/**
	 * The singleton instance of {@code Imaging}.
	 */
	private static final Imaging INSTANCE = new Imaging();

    /**
     * Equivalent {@link #BYTE}
     */
    @SuppressWarnings("unused")
	private static final Unit<Information> OCTET = BYTE;

    /**
     * A pixel has 4 channels which define transparency (alpha), red, green and
     * blue color values. Each channel is one byte wide.
     * 
     * @see #BYTE
     * @see <a href="http://www.convert-me.com/en/convert/length/pixel.html?u=pixel&v=177">Pixel Converter</a>
     */
    public static final Unit<Information> PIXEL_BYTE = addUnit(BYTE.multiply(4.0));

    
    /**
     * A pixel is equivalent to 0.0002636 metre.
     * 
     * @see <a href="http://www.convert-me.com/en/convert/length/pixel.html?u=pixel&v=177">Pixel Converter</a>
     */
    public static final Unit<Length> PIXEL = addUnit(METRE.multiply(0.0002636));

    /**
     * Pixel per inch describe the resolution for any output device (monitor,
     * printer) that deals with outputting digital raster images.
     * 
     * @see #INCH
     * @see #PIXEL
     */
    public static final Unit<Resolution> PIXEL_PER_INCH = addUnit(PIXEL.divide(INCH).asType(Resolution.class));

    /**
     * Equivalent {@link #PIXEL}
     */
    @SuppressWarnings("unused")
	private static final Unit<Length> COMPUTER_POINT = PIXEL;
    
    /**
	 * Holds the dimensionless unit <code>IMAGE</code>.
	 * 
	 */
	public static final Unit<Dimensionless> IMAGE = addUnit(new ProductUnit<>(), "Image", "img");

    ///////////////
    // Frequency //
    ///////////////
    /**
     * A unit used to measure the frequency (rate) at which an imaging device
     * produces unique consecutive images (standard name <code>fps</code>).
     */
    protected static final Unit<Frequency> FRAMES_PER_SECOND = addUnit(ONE.divide(SECOND)).asType(Frequency.class);
    
	/**
	 * Default constructor (prevents this class from being instantiated).
	 */
	private Imaging() {
	}


	@Override
	public String getName() {
		return Imaging.class.getSimpleName();
	}

	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return the Seismic system instance.
	 */
	public static final SystemOfUnits getInstance() {
		return INSTANCE;
	}

	/**
	 * Adds a new unit not mapped to any specified quantity type and puts a text as
	 * symbol or label.
	 *
	 * @param unit    the unit being added.
	 * @param name    the string to use as name
	 * @param text    the string to use as label or symbol
	 * @param isLabel if the string should be used as a label or not
	 * @return <code>unit</code>.
	 */
	private static <U extends Unit<?>> U addUnit(U unit, String name, String text, boolean isLabel) {
		if (isLabel) {
			SimpleUnitFormat.getInstance().label(unit, text);
			EBNFUnitFormat.getInstance().label(unit, text);
		}
		if (name != null && unit instanceof AbstractUnit) {
			return Helper.addUnit(INSTANCE.units, unit, name);
		} else {
			INSTANCE.units.add(unit);
		}
		return unit;
	}
	
	/**
	 * Adds a new unit not mapped to any specified quantity type.
	 *
	 * @param unit
	 *            the unit being added.
	 * @return <code>unit</code>.
	 */
	@SuppressWarnings("unused")
	private static <U extends Unit<?>> U addUnit(U unit) {
		INSTANCE.units.add(unit);
		return unit;
	}

	/**
	 * Adds a new named unit to the collection.
	 *
	 * @param unit
	 *            the unit being added.
	 * @param name
	 *            the name of the unit.
	 * @return <code>unit</code>.
	 */
	@SuppressWarnings({ "unchecked" })
	private static <U extends Unit<?>> U addUnit(U unit, String name, String label) {
		return addUnit(unit, name, label, true);
	}

	/**
	 * Adds a new unit and maps it to the specified quantity type.
	 *
	 * @param unit
	 *            the unit being added.
	 * @param type
	 *            the quantity type.
	 * @return <code>unit</code>.
	 */
	private static <U extends AbstractUnit<?>> U addUnit(U unit, String name, String label, Class<? extends Quantity<?>> type) {
		INSTANCE.units.add(unit);
		INSTANCE.quantityToUnit.put(type, unit);
		return unit;
	}
}
