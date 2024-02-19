nome = input()
salarioFixo = float(input())
vendas = float(input())

comissao = vendas * 0.15

salario = comissao + salarioFixo

print(f"TOTAL = R$ {salario:.2f}")