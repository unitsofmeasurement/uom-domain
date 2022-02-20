/*
 *  Units of Measurement Weather & Climate
 *  Copyright (c) 2005-2022, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tech.uom.domain.weather.wind;

import static tech.units.indriya.AbstractQuantity.NONE;
import static tech.uom.domain.weather.wind.BeaufortScale.BeaufortNumber.*;

import javax.measure.Quantity;
import javax.measure.quantity.Speed;

import tech.uom.lib.common.function.Nameable;
import tech.units.indriya.quantity.QuantityRange;

/**
 * @author Werner Keil
 * @version 1.0
 * @see <a
 *      href="https://en.wikipedia.org/wiki/Beaufort_scale">
 *      Wikipedia: Beaufort scale</a>
 */
public class BeaufortScale extends QuantityRange<Speed>
		implements Nameable {

	/**
	 * The Beaufort number
	 */
	public static enum BeaufortNumber {
		UNKNOWN, ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE
	}

	private final BeaufortNumber number;

	public BeaufortNumber getNumber() {
		return number;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see Range
	 */
	protected BeaufortScale(Quantity<Speed> min,
			Quantity<Speed> max, BeaufortNumber num) {
		super(min, max);
		this.number = num;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see Range
	 */
	protected BeaufortScale(Quantity<Speed> min,
			Quantity<Speed> max) {
		this(min, max, UNKNOWN);
	}

	/**
	 * Returns an {@code SaffirSimpsonHurricaneWindScale} with the specified
	 * values.
	 *
	 * @param min
	 *            The minimum value for the wind scale.
	 * @param max
	 *            The maximum value for the wind scale.
	 * @param num
	 *            The {@link BeaufortNumber} of the wind scale.
	 * @return an {@code BeaufortScale} with the values
	 *         present
	 */
	public static final BeaufortScale of(Quantity<Speed> min,
			Quantity<Speed> max, BeaufortNumber num) {
		return new BeaufortScale(min, max, num);
	}

	@Override
	public boolean hasMinimum() {
		return getMinimum() != null
				&& !NONE.equals(getMinimum())
				&& !(getMinimum().getUnit() == null || getMinimum().getValue() == null);
	}

	@Override
	public boolean hasMaximum() {
		return getMaximum() != null
				&& !NONE.equals(getMaximum())
				&& !(getMaximum().getUnit() == null || getMaximum().getValue() == null);
	}

	@Override
	public String toString() {
		return getName() + " [number=" + number + ", minimum="
				+ getMinimum() + ", maximum=" + getMaximum() + "]";
	}

	@Override
    public String getName() {
		return "Beaufort wind scale";
	}
}
