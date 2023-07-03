package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

class BishopBlackTest {

    @Test
    void whenPositionIsC3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        assertThat(bishopBlack.position()).isEqualTo(Cell.C3);
    }

    @Test
    void whenCopyToA1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        assertThat(bishopBlack.copy(Cell.A1).position()).isEqualTo(Cell.A1);
    }

    @Test
    void whenWayToG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5)).isEqualTo(expected);
    }

    @Test
    void whenException() {
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            new BishopBlack(Cell.C1).way(Cell.G6);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to G6");
    }
}
