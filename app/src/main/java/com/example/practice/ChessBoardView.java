package com.example.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import Interfaces.ChessGameLogic;
import Interfaces.ChessPieceEnums;
import Utils.myUtils;
import chessLogic.ChessLogicBoard;
import chessLogic.Pair;

public class ChessBoardView extends View {


    Paint paint,circlePaint;
    final int BOARD_DIMENSION = 8;
    int fieldSize = -1;
    TextView displayField = null;
    ChessGameLogic gameLogic;
    ChessPieceEnums[][] pieceEnums;
    boolean whitesTurn = true;
    boolean boardMoveState = false;
    Pair[] legalMoves = null;
    int boardxCordinatesToMove,boardyCordinatesToMove = -1;
    public ChessBoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();

    }

    private void initialize() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        gameLogic = new ChessLogicBoard();
        displayField = findViewById(R.id.titleTextView);

        circlePaint = new Paint();
        circlePaint.setColor(Color.GREEN);  // Set color to green
        circlePaint.setStyle(Paint.Style.FILL);


    }

    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

          if (fieldSize == -1)
            fieldSize = getWidth() / BOARD_DIMENSION;

        //if (displayField == null)
            //displayField = findViewById(R.id.titleTextView);
        pieceEnums =   gameLogic.getBoard();
        Bitmap pieceBitmap ;
        boolean paintSquare = false;

        for (int i = 0; i < BOARD_DIMENSION; i++){
            for (int j = 0; j < BOARD_DIMENSION; j++ ){
                if (paintSquare){
                    canvas.drawRect(j*fieldSize, i*fieldSize,  (j+1)*fieldSize, (i+1)*fieldSize, paint);
                }
                if (pieceEnums != null && pieceEnums[i][j] != null){

                    pieceBitmap = getPieceBitmap(pieceEnums[i][j]);
                    canvas.drawBitmap(pieceBitmap,  j*fieldSize,  i*fieldSize, null);
                }

                paintSquare = !paintSquare;
            }
            paintSquare = !paintSquare;
        }


        if (boardMoveState && legalMoves != null){
            Log.i("help",legalMoves.length + "");
            int counter = 0;
            while(legalMoves[counter] != null){
                Log.i("USLO U LOOP", "");
                Pair pair = legalMoves[counter];
                Log.i(pair.getX()*fieldSize+"",pair.getY()*fieldSize+"");
               // canvas.drawCircle(pair.getX()*fieldSize, getY()*fieldSize, fieldSize, circlePaint);
                canvas.drawCircle(pair.getX()*fieldSize + fieldSize/2,pair.getY()*fieldSize + fieldSize/2 , fieldSize/4, circlePaint);
             //   canvas.drawCircle(0,0 , fieldSize/2, circlePaint);
                counter++;

            }
        }

    }
    public boolean onTouchEvent(MotionEvent event){
        float xTouchCordinate = -1;
        float yTouchCordinate = -1;
        int boardxCordinate;
        int boardyCordinate;



        if (event.getAction() == MotionEvent.ACTION_DOWN){
           xTouchCordinate = event.getX();
           yTouchCordinate = event.getY();
           boardxCordinate = (int) (xTouchCordinate/fieldSize);
           boardyCordinate = (int) (yTouchCordinate/fieldSize);

           displayField.setText( myUtils.convertToCHAR(boardxCordinate) + "" + (boardyCordinate+1));
            String log = "";


           if (!gameLogic.isEmptyField(boardxCordinate,boardyCordinate) && gameLogic.getColor(boardxCordinate,boardyCordinate) == whitesTurn && !boardMoveState){

               boardMoveState = !boardMoveState;
               boardxCordinatesToMove = boardxCordinate;
               boardyCordinatesToMove = boardyCordinate;
               legalMoves = gameLogic.getLegalMoves(boardyCordinate,boardxCordinate);


           } else if (boardMoveState  && gameLogic.makeMove(boardxCordinatesToMove,boardyCordinatesToMove,boardxCordinate,boardyCordinate) ) {
               Log.i("USLO U POTEZ","");
               whitesTurn = !whitesTurn;
               boardMoveState = !boardMoveState;

           }else if(boardMoveState){
               Log.i("USLO U VRACANJE","");
               boardMoveState = !boardMoveState;

           }
            if (whitesTurn) {
                log = "WHITES TURN:";
            }else
                log = "BLACKS TURN:";

            if (boardMoveState) {
                log += "MOVE";
            }else
                log += "PIECE";



            displayField.setText(log);


            invalidate();

           return true;
        }
         return super.onTouchEvent(event);
    }
    public void setTextView(TextView view){
        this.displayField = view;
    }

    private Bitmap getPieceBitmap(ChessPieceEnums pieceEnum){
        Bitmap pieceBitmap = null;



        switch (pieceEnum) {
            case WHITE_PAWN:
                pieceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.white_pawn);
                break;
            case BLACK_PAWN:
                pieceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.black_pawn);
                break;
            case WHITE_ROOK:
                pieceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.white_rook);
                break;
            case WHITE_KNIGHT:
                pieceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.white_knight);
                break;
            case WHITE_BISHOP:
                pieceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.white_bishop);
                break;
            case WHITE_KING:
                pieceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.white_king);
                break;
            case WHITE_QUEEN:
                pieceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.white_queen);
                break;
            case BLACK_ROOK:
                pieceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.black_rook);
                break;
            case BLACK_KNIGHT:
                pieceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.black_knight);
                break;
            case BLACK_BISHOP:
                pieceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.black_bishop);
                break;
            case BLACK_KING:
                pieceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.black_king);
                break;
            case BLACK_QUEEN:
                pieceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.black_queen);
                break;
            default:
                break;
        }

        if (pieceBitmap != null)
            pieceBitmap = Bitmap.createScaledBitmap(pieceBitmap, fieldSize, fieldSize, true);

        return pieceBitmap;
    }

}
