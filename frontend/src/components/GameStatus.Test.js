import { render, screen } from "@testing-library/react";
import GameStatus from "./GameStatus";

test("shows the game result", () => {
    render(<GameStatus result="Player wins!" />);
    expect(screen.getByTestId("game-result").textContent).toBe("Player wins!");
});