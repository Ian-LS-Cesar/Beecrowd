dinheiro = float(input())
total = dinheiro
nota100, nota50, nota20, nota10, nota5, nota2, moeda1, moeda50, moeda025, moeda010, moeda005, moeda001 = 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0

if (dinheiro >= 100):
    nota100 += dinheiro // 100
    dinheiro -= 100 * nota100

if (dinheiro >= 50):
    nota50 = dinheiro // 50
    dinheiro -= 50 * nota50

if (dinheiro >= 20):
    nota20 = dinheiro // 20
    dinheiro -= 20 * nota20

if (dinheiro >= 10):
    nota10 = dinheiro // 10
    dinheiro -= 10 * nota10

if (dinheiro >= 5):
    nota5 = dinheiro // 5
    dinheiro -= 5 * nota5

if (dinheiro >= 2):
    nota2 = dinheiro // 2
    dinheiro -= 2 * nota2

if (dinheiro >= 1):
    moeda1 += int(dinheiro)
    dinheiro -= 1 * moeda1

dinheiro *= 100

if (dinheiro >= 50):
    moeda50 = dinheiro // 50
    dinheiro -= 50 * moeda50

if (dinheiro >= 25):
    moeda025 = dinheiro // 25
    dinheiro -= 25 * moeda025

if (dinheiro >= 10):
    moeda010 = dinheiro // 10
    dinheiro -= 10 * moeda010

if (dinheiro >= 5):
    moeda005 = dinheiro // 5
    dinheiro -= 5 * moeda005

if (dinheiro >= 1):
    moeda001 = int(dinheiro)

print("NOTAS:")
print(f"{nota100:.0f} nota(s) de R$ 100.00")
print(f"{nota50:.0f} nota(s) de R$ 50.00")
print(f"{nota20:.0f} nota(s) de R$ 20.00")
print(f"{nota10:.0f} nota(s) de R$ 10.00")
print(f"{nota5:.0f} nota(s) de R$ 5.00")
print(f"{nota2:.0f} nota(s) de R$ 2.00")

print("MOEDAS:")
print(f"{moeda1:.0f} moeda(s) de R$ 1.00")
print(f"{moeda50:.0f} moeda(s) de R$ 0.50")
print(f"{moeda025:.0f} moeda(s) de R$ 0.25")
print(f"{moeda010:.0f} moeda(s) de R$ 0.10")
print(f"{moeda005:.0f} moeda(s) de R$ 0.05")
print(f"{moeda001:.0f} moeda(s) de R$ 0.01")