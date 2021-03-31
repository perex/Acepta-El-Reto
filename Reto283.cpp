//Reto 283: Invirtiendo en Jaén
#include <iostream>

using namespace std;

int buscarMax(char **mapa, const int ROWS, const int COLUMNS, int fila, int columna)
{
	if (fila<0 || columna<0 || fila+1>ROWS || columna+1>COLUMNS || mapa[fila][columna] == ' ')
		return 0;
	else
	{
		mapa[fila][columna] = ' ';
		return 1 
			+ buscarMax(mapa, ROWS, COLUMNS, fila, columna-1) 
			+ buscarMax(mapa, ROWS, COLUMNS, fila, columna+1) 
			+ buscarMax(mapa, ROWS, COLUMNS, fila-1, columna) 
			+ buscarMax(mapa, ROWS, COLUMNS, fila+1, columna);
	}
}


int main()
{
	int ROWS, COLUMNS;	   
  int max, actual;    
	string linea;	
		
	while (cin >> ROWS && cin >> COLUMNS) 
	{
		char** mapa = new char*[ROWS];
		for (int i=0; i< ROWS; i++)
			mapa[i] = new char[COLUMNS];
		
		cin.get();
		for (int i = 0; i < ROWS; ++i) {
			getline(cin, linea);
			for (int j = 0; j < COLUMNS; ++j) {
				mapa[i][j] = linea[j];
			}
		}
		max = 0;
		for (int i = 0; i < ROWS; ++i)
		{
			for (int j = 0; j < COLUMNS; ++j)
					if (mapa[i][j] == '#')
					{
						actual = buscarMax(mapa, ROWS, COLUMNS, i, j);
						if (actual > max)
							max = actual;
					}
			
		}
		cout << max << endl;		
	 }  
   
   return 0;
	
}
