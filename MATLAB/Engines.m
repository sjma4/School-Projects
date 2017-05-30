% ------------- Computations On Heat Transfer within a Combustion Engine ----------

%This program computes the Overall Heat Transfer, Conduction, Convection, and Radiation based on the user input
%The user will first choose a metal to evaluate based on the table printed to the Command Window
%The user will input a series of values for Temperatures in Kelvin, and Cylinder values in meters
%It will display a table of the commonly used materials in a Combustion in a Combustion Engine and their Thermal Conductivity values and Emissivity constant
%After computation, two 3-dimensional bar graphs will be displayed
%First Graph - Displays Computations on the Metal the User Selected
%Second Graph - Compares these values with the heat transfer values of the other common metals. 
             %- Each metal not selected will have their values computed using their emissivity and conductivity values 
%Each column (X-Axis of Graph) of the matrix are the computed values for the Metal
%Each row (Y-Axis of Graph)of the matrix is the different modes of heat transfer in this order:
    %(Conduction, Over Heat Transfer, Convection, Radiation)
% Z-Axis contains the computed values. 

%-----------------------------USER CHOSEN METAL-----------------------------
%----------------Graph Will Display Results For This One Metal--------------

%Create Material Table to view options
Material = {'Aluminum'; 'Carbon Steel'; 'Cast Iron';'Copper'; 'Titanium'};
Thermal_Conductivity  = [240;43;80;400;23];
Emissivity = [0.05; 0.32; 0.96; 0.05;0.19];
Comments = string({'Thermal Conductivity is in W/mK',' Emissivity is a constant';});
T = table(Thermal_Conductivity, Emissivity, 'RowNames', Material)
disp(Comments);

%Obtain user input for Material
%User Input is case sensitive
%Must match exactly how it is on the table
prompt_x = {'Choose a Material'};
dlg_titleX = 'Material';
x = inputdlg(prompt_x, dlg_titleX, [1, 50]);
inp = x(1);

%Obtain user Input for values
prompt_y = {'Cylinder Diameter (m)', 'Cylinder Thickness (m)','Gas Temperature (K)','Coolant Temperature (K)', 'Surface Temperature (K)'};
dlg_titleY = 'Value Input';
y = inputdlg(prompt_y, dlg_titleY, [1 50;1 50; 1 50;1 50 ; 1 50]);

%Grab constants from Thermal_Conductivity Table
for index = 1:5
    if (strcmp(inp,Material(index)) == 1)   
    %Obtain k constant
    k = Thermal_Conductivity(index);
    %Obtain Emissivity
    E = Emissivity(index);
    end
end

%Convert Cell Array y to a Normal Array
Int_Y = str2double(y);
%Rename the user input values for more legible variable names
Cylinder_Diameter = Int_Y(1);
Cylinder_Thickness = Int_Y(2);
Gas_Temperature = Int_Y(3);
Coolant_Temperature = Int_Y(4);
Surface_Temperature = Int_Y(5);

%Constants for gas & coolant Coefficients (W/Km^2)
%Convection Water Coefficient & Gas Coefficient are pre-selected, they typically have a range 
water_coeff = 1000;
gas_coeff = 37;
Stef_Boltzman_Constant = 5.67 * 10 ^-8;

%Display Data Of Chosen Metal
disp("Your Chosen Metal: " + inp)
%Calculations for each heat transfer mode here
%Thermal Conductance
 C = (k / Cylinder_Thickness);
 disp("Thermal Conductance is " + C + " W/mK")
 
%Thermal Resistance
R = (Cylinder_Thickness / k);
disp("Thermal Resistance is " + R + " mK/W")

%Compute Conduction
Conc = ((k*(abs((Gas_Temperature - Coolant_Temperature))))/Cylinder_Diameter);
disp("Conduction: " + Conc + " W/m^2");

%Compute Convection
Conv = (water_coeff * (abs((Gas_Temperature - Surface_Temperature))));
disp("Convection: " + Conv + " W/m^2");

%Compute Radiation
Rad = (E * Stef_Boltzman_Constant * (Surface_Temperature)^4);
disp("Radiation: " + Rad + " W/m^2");

%Compute Heat Transfer Through the Cylinder Wall
Heat_Through_Wall = (abs(Gas_Temperature - Coolant_Temperature))/((1/gas_coeff) + (Cylinder_Thickness/k) + (1/water_coeff));
disp("Overall Heat Transfer: " + Heat_Through_Wall + " W/m^2" + newline);

%Store Computed Info Into New Array
Input_Array = [Conc; Conv; Rad; Heat_Through_Wall;];

%Create Graph for User Chosen Material
%Label Axes
figure('Name', 'Chosen Metal Graph')
bar3(Input_Array)
xlabel('Metal')
ylabel('Type')
zlabel('Heat Transfer (W/m^2)')
set(gca,'XTickLabel', inp);
set(gca,'YTickLabel', {'Conduction', 'Overall Transfer', 'Convection', 'Radiation'});


%---------------------Compute Heat Transfer For Every Other Metal--------------
%------------------Graph Will Display Results For All Other Metal--------------

%Search for Emissivity and Conducivity Constants for Other Metals
%Create 0 Arrays for Emissivity and Conductivity
new_k = zeros(1,4);
new_E = zeros(1,4);

%Store Emissivity and Conductivity into new_k and new_E
for i = 1:5
    if (strcmp(inp,Material(i)) == 0)   
    %Obtain k constant
    new_k(i) = Thermal_Conductivity(i);
    %Obtain Emissivity
    new_E(i) = Emissivity(i);
    end       
end

%Create 5x4 Array to store all values
%Values are Overall Heat Transfer, Cond, Conv, Rad computations of the
%other metals
%Including originally chosen metal
Graph_All = zeros(4,5);

%Variables to store position number of each metal in table
%This graph will be static and be ordered Alphabetically
%Index of each element represent their position on the graph
position_num = ["Aluminum"; "Carbon Steel"; "Cast Iron"; "Copper"; "Titanium"];

%This Loop will calculate the Heat Transfer values for the other metals
%And store them into the corresponding position
%This does not include the user's input
for j = 1:5
     if (strcmp(inp,position_num(j)) == 0)          
         
            %Label which label values are for
            disp("Metal: " + position_num(j))
            
            %Thermal Conductivity and Resistance Values will not be used in the graph
            %Thermal Conductance
            C = (new_k(j) / Cylinder_Thickness);
            disp("Thermal Conductance is " + C + " W/mK")
 
            %Thermal Resistance
            R = (Cylinder_Thickness / new_k(j));
            disp("Thermal Resistance is " + R + " mK/W")

            %Compute Conduction
            Conc = ((new_k(j)*(abs((Gas_Temperature - Coolant_Temperature))))/Cylinder_Diameter);
            %Store into Array
            Graph_All(1,j) = Conc;
            disp("Conduction: " + Conc+" W/m^2")
            
            %Compute Convection
            Conv = (water_coeff * (abs((Gas_Temperature - Surface_Temperature))));
            %Store into Array
            Graph_All(2,j) = Conv;
            disp("Convection: " + Conv+ " W/m^2")
            
            %Compute Radiation
            Rad = (new_E(j) * Stef_Boltzman_Constant * (Surface_Temperature)^4);
            %Store into Array
            Graph_All(3,j) = Rad;
            disp("Radiation: " + Rad +" W/m^2")
            
            %Heat Transfer Through the Cylinder Wall
            Heat_Through_Wall = (abs(Gas_Temperature - Coolant_Temperature))/((1/gas_coeff) + (Cylinder_Thickness/new_k(j)) + (1/water_coeff));
            %Store into Array
            Graph_All(4,j) = Heat_Through_Wall;
            disp("Overall Heat Transfer: " + Heat_Through_Wall + " W/m^2" + newline)
                   
     end
end

%Copy information from metal chosen based on its position
for col = 1:5
    if (strcmp(inp,position_num(col)) == 1) 
        Graph_All(1,col) = Input_Array(1);
        Graph_All(2,col) = Input_Array(2); 
        Graph_All(3,col) = Input_Array(3);
        Graph_All(4,col) = Input_Array(4);
    end
end

%Array that holds ALL of the computed values for ALL Metals
%Prints Current  Values of all Values
Graph_All;

%Code block for creating 3D Graph with All Metals using User Input
figure('Name','Comparing All Metals')
bar3(Graph_All)
xlabel('Metal')
ylabel('Type')
zlabel('Heat Transfer (W/m^2)')
set(gca,'XTickLabel', {'Aluminum', 'Carbon Steel', 'Cast Iron', 'Copper', 'Titanium'});
set(gca,'YTickLabel', {'Conduction', 'Overall Transfer', 'Convection', 'Radiation'});
