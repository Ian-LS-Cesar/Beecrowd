Lados = [float(x) for x in input().split(' ')]
Lados.sort(reverse=True)
A, B, C = Lados

    
if (A >= (B + C)):    
    print("NAO FORMA TRIANGULO")
else:
    if (A**2 == (B**2) + (C**2)):
        print("TRIANGULO RETANGULO")
    elif (A**2 > (B**2) + (C**2)):
        print("TRIANGULO OBTUSANGULO")
    else:
        print("TRIANGULO ACUTANGULO")
    if (A == B == C):
            print("TRIANGULO EQUILATERO")

    elif (A == B != C or A == C != B or A != B == C):
            print("TRIANGULO ISOSCELES")

