# demo_wally_app
A basic application for the calculation of the heat transfer inside a solid material.

This is an application designed to solve the equation of conductivity in a solid material.

[Space for equation]

Where:
• K [W/m/K] is the conductivity constant (this is defined for each material in the literature)
• qA [W/m2] is the heat transfer ratio per area unit, this is the quantity of heat that is transferred to a material per unit of area.
• T [°C] is the temperature in for each point of the distance X
• X [m] is the distance of the material.

Because of the equation is a differential equation it is necessary a boundary condition, in this case you should set a Temperature value for the position where X=0.

After that, the application will calculate the variation of the temperature in the material along the distance, the results will be shown by a line graph and the exact value of the temperature at the end position.

Notice:
• This application does not consider heat losing, take care when the K value is set, this must not be 0 or negative.
• The value of the temperature could be used in °C units, this is because the Kelvin (K) and (°C) has the same delta (dT).

How’s it works?
The interface of the application is described in the ilustration below:

[Space for image]

Credits
This application was developed by Jhoan Sebastian Saldarriaga Giraldo using
KOTLIN, Android Studio and GraphView plugin (from jjoe64-GitHub)
