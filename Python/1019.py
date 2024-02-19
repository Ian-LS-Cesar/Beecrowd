N = int(input())
horas, minutos, segundos = 0, 0, 0

if (N >= 3600):
    horas = N // 3600
    N = N - 3600 * horas
if (N >= 60):
    minutos = N // 60
    N = N - 60 * minutos
segundos = N

print(f"{horas}:{minutos}:{segundos}")