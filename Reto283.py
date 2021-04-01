# Reto 283: Invirtiendo en Jaén
mapa1 = [
			["","#","#",""],
			["","","",""],
			["","#","#","#"],
			["","","","#"]
		]; #sol 4

mapa2 = [
			["", "#", "", "#", "", "", "", ""],                
			["", "#","#", "", "", "", "",""],
			["#","#","#", "", "", "", "",""],
            ["", "", "#", "", "", "", "", ""]
        ]#7
mapa3 = [
			["","#","", "#","","","", "#"],                
            ["","#","#","#","","","", "#"],
            ["","#","#","#","","","", "#"],
            ["#","","", "", "","","", ""],
            ["","#","","#", "","","", ""],
            ["","#","#","#","","#","#",""],
            ["#","#","#","","","#","#",""],
            ["", "", "#","","","", "", ""]
        ]#9

mapa4 = [
			["#","#","#","","","","#", "#", "#","#"],                
            ["#","#","","","","","", "", "", ""],
            ["#","#","#","#","#","#","#","#","#","#"]
            
        ]#15

mapas=[mapa1, mapa2, mapa3, mapa4]

def buscarMax(mapa, fila, columna):
	
	if ( (fila < 0) or (columna < 0) or (fila+1 > len(mapa)) or (columna+1>len(mapa[fila])) or (mapa[fila][columna] == "")):
		return 0
	else:		
		mapa[fila][columna] = "";
		return 1 + buscarMax(mapa, fila, columna-1) + buscarMax(mapa, fila, columna+1) + buscarMax(mapa, fila-1, columna) + buscarMax(mapa, fila+1, columna)


for mapa in mapas:
	max = 0
	for i in range(len(mapa)):
		for j in range(len(mapa[i])):
			if (mapa[i][j] == "#"):
				actual = buscarMax(mapa, i, j)
				if (actual > max):
					max = actual

	print(max)




