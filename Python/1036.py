A, B, C = map(float, input().split())

delta = B**2 - 4 * A * C

if (A == 0 or delta < 0):
    print("Impossivel calcular")
else:
    bhaskaraPosi = (-B + ((delta)) ** 0.5) / (2 * A)
    bhaskaraNeg = (-B - ((delta)) ** 0.5) / (2 * A)
    print(f"R1 = {bhaskaraPosi:.5f}")
    print(f"R2 = {bhaskaraNeg:.5f}")