import numpy as np
import matplotlib.pyplot as plt

# Spiral
# We create a spiral by calculating the coordinates of each point in the spiral
# theta is the angle in radians, which increases with each point in the spiral
# We use np.linspace to create an array of angles from 0 to 8*pi with 180*8 points
# The spiral will have 8 full turns, with each turn having 180 points
# The angle is divided into 8 full turns, so we multiply by 8
# 180*8 is the number of points in the spiral, which gives us a smooth curve
# The angle is in radians, so we use np.pi to convert degrees to radians
# The angle is divided into 8 full turns, so we multiply by 8
# The angle is in radians, so we use np.pi to convert degrees to radians
theta = np.linspace(0, 8*np.pi, 180*8)
# x1 and x2 are the coordinates of the spiral
# r is the radius, which increases with each iteration
# 0.03 is the increment of the radius for each point in the spiral
# x1 = r*cos(theta)
# x2 = r*sin(theta)
# We use a list to store the coordinates of the spiral
x1 = []
x2 = []

r=0
for i in range(len(theta)):
    x1.append((r+i*0.03)*np.cos(theta[i]))
    x2.append((r+i*0.03)*np.sin(theta[i]))

# Plot the spiral
# We use matplotlib to plot the spiral
plt.style.use('dark_background')
plt.rcParams['figure.figsize'] = [10, 10]
plt.rcParams['figure.dpi'] = 100   
fig, ax = plt.subplots(1)
ax.plot(x1, x2, color='blue', linewidth=3)
ax.set_aspect(1)

plt.margins(0.2)
plt.show()