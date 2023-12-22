package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position aux = new Position(0, 0);
		
		// ABOVE
		aux.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}
		
		//Below
		aux.setValues(position.getRow() + 1, position.getColumn());
		if(getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}
		
		//Left
		aux.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}
		
		//Right
		aux.setValues(position.getRow(), position.getColumn() + 1);
		if(getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}
		
		//NW
		aux.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}
		
		//NE
		aux.setValues(position.getRow() - 1, position.getColumn() + 1);
		if(getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}
		
		//SW
		aux.setValues(position.getRow() + 1, position.getColumn() - 1);
		if(getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}
		
		//SE
		aux.setValues(position.getRow() + 1, position.getColumn() + 1);
		if(getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}
		
		
		return mat;
	}

}
