import matplotlib.pyplot as plt
import numpy as np

# Años desde 1980 hasta 2025
years = np.arange(1980, 2026)

# Datos aproximados y ficticios de cuota de mercado (%) para ilustrar la evolución
windows_market = np.piecewise(years,
                              [years < 1985, (years >= 1985) & (years < 1995), (years >= 1995) & (years < 2005),
                               (years >= 2005) & (years < 2015), (years >= 2015)],
                              [0, lambda x: np.linspace(0, 80, len(x)), 80, 70, 75])

macos_market = np.piecewise(years,
                            [years < 1984, (years >= 1984) & (years < 1997), (years >= 1997) & (years < 2005),
                             (years >= 2005) & (years < 2015), (years >= 2015)],
                            [0, lambda x: np.linspace(0, 5, len(x)), 3, 8, 15])

linux_market = np.piecewise(years,
                            [years < 1991, (years >= 1991) & (years < 2005), (years >= 2005) & (years < 2015),
                             (years >= 2015)],
                            [0, lambda x: np.linspace(0, 1, len(x)), 1, 5])

plt.figure(figsize=(12, 6))
plt.plot(years, windows_market, label="Windows", color="blue")
plt.plot(years, macos_market, label="Mac OS", color="grey")
plt.plot(years, linux_market, label="Linux", color="green")

plt.title("Evolución aproximada de cuota de mercado (%) de sistemas operativos (1980-2025)")
plt.xlabel("Año")
plt.ylabel("Cuota de mercado (%)")
plt.legend()
plt.grid(True)
plt.show()
