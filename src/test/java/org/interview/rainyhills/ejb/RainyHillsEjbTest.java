package org.interview.rainyhills.ejb;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RainyHillsEjbTest {

    @Test
    public void shouldBeZeroWhenArrayOfHillsIsNull() {
        assertThat(new RainyHillsEjb().findWaterVolume(null)).isEqualTo(0);
    }

    @Test
    public void shouldBeZeroWhenArrayOfHillsIsEmpty() {
        assertThat(new RainyHillsEjb().findWaterVolume(new int[]{})).isEqualTo(0);
    }

    @Test
    public void shouldCalculateEasyCase() {
        assertThat(new RainyHillsEjb().findWaterVolume(new int[]{4, 1, 1, 0, 2, 3})).isEqualTo(8);
    }

    @Test
    public void shouldCalculateComplexCaseWithManyUpsAndDowns() {
        assertThat(new RainyHillsEjb().findWaterVolume(
                new int[]{1, 2, 3, 3, 2, 2, 3, 4, 4, 3, 2, 3, 4, 5, 2, 0 })).isEqualTo(6);
    }

    @Test
    public void shouldCalculateWhenVolumeIsMoreWhenIntCanHandle() {
        assertThat(new RainyHillsEjb().findWaterVolume(new int[]{2_147_483_647, -2_147_483_648, 2_147_483_647}))
                .isEqualTo(4294967295L);
    }

    @Test
    public void shouldCalculateWithNegativeIntPresent() {
        assertThat(new RainyHillsEjb().findWaterVolume(new int[]{0, 3, -1, 1, 3, 0})).isEqualTo(6);
    }

    @Test
    public void shouldCalculateZeroWhenNoPlaceForWater() {
        assertThat(new RainyHillsEjb().findWaterVolume(new int[]{0, 3, 4, 4, 3, 0})).isEqualTo(0);
    }

}
