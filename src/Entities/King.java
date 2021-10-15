package Entities;

/**
* This class represents a King chess piece for our chess game. 
*/
public class King extends ChessPiece {

  public King(int row, int column, String color){

    super(row, column, color );

    // Using the Characters package in order to use unicode to set
    // Latin characters for K, in order to avoid confusion with
    // the letters used for Knight chess pieces.
    // Learned from: https://docs.oracle.com/javase/tutorial/i18n/text/unicode.html
    if(color.equals("black")){
      super.setLetter(Character.toChars(0x0198)[0]);
    }
    else{
      super.setLetter(Character.toChars(0x0199)[0]);
    }
  }
}
