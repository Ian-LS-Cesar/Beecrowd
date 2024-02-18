A,B,C = map(float, input().split())
pi = 3.14159

areaTriangulo = (A * C)/2
areaCirculo = pi * C**2
areaTrapezio = ((A + B) * C)/2
areaQuadrado = B ** 2
areaRetangulo = A * B

print(f"TRIANGULO: {areaTriangulo:.3f}\nCIRCULO: {areaCirculo:.3f}\nTRAPEZIO: {areaTrapezio:.3f}\nQUADRADO: {areaQuadrado:.3f}\nRETANGULO: {areaRetangulo:.3f}\n")
