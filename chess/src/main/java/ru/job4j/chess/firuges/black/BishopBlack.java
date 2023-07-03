package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int x = position.getX();
        int y = position.getY();
        int deltaX = dest.getX() > x ? 1 : -1;
        int deltaY = dest.getY() > y ? 1 : -1;
        Cell[] steps = new Cell[Math.abs(dest.getX() - x)];
        for (int index = 0; index < steps.length; index++) {
            x = deltaX == 1 ? x + 1 : x - 1;
            y = deltaY == 1 ? y + 1 : y - 1;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int xPath = Math.abs(dest.getX() - source.getX());
        int yPath = Math.abs(dest.getY() - source.getY());
        return xPath == yPath;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}