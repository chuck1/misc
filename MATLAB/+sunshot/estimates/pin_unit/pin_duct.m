classdef pin_duct < handle
    %UNTITLED Summary of this class goes here
    %   Detailed explanation goes here
    
    properties
        D,
        P_T,
        P_L,
        N_L,
        N_T,
        
        
        H,
        S_L,
        S_T,
        S_D,
        A_min,
        A_hs,
        
        f,
        dp,
        mdot,
        v_max,
        v,
        
        T_in,
        T_out,
        T_av,
        qpp,
        dh
        
        rho_av,
        
        mu_av,
        
        k_f_av,
        
        Pr_av
    end
    
    methods
        function design_for_dp(c,D,P_T)
            %% independent variables
            c.D = D;
            c.P_T = P_T;
            
            %% evaluate
            setS_T();
            
            setP_L();
            setS_L();
            
            setH();
            setA_min = (S_T-D)*H;
            w = S_T;

            %% constants
            dp  = 28000;
            
            
            T_av = 848.15;

            rho = CO2.density(T_av);
            pr = CO2.prandtl(T_av);
            mu = 36.7e-6;
            k_f = CO2.conductivity(T_av);

            T_av = 848.15;
            sigma = 5.67e-8;
            epsilon = 0.95;
            h_nat = 15;
            T_inf = 293.15;

            %% velocity
            
            C_1 = 2*dp*S_L / ( rho*f );

            C_2 = ( rho*A_min*dh ) / ( w*qpp );

            v_max = (C_1/C_2)^(1/3);

            mdot = rho*A_min*v_max;

            %% unit cell pressure drop

            dp = 2*(rho*v_max^2/2)*f;

            %% efficiency

            Re = rho*D*v_max/mu;

            % Incropera eq 7.64
            C =...
                ((Re>1e3)&&(Re<=2e5)) * 0.35*(S_T/S_L)^(1/5) +...
                (Re>2e5) * 0.21;
            m =...
                ((Re>1e3)&&(Re<=2e5)) * 0.6 +...
                (Re>2e5) * 0.84;

            Nu = C*Re^m*pr^0.36*(pr/pr)^(0.25);

            h = k_f*Nu/D;

            dT1 = qpp/h;

            dT2=0;
            T = T_av + dT1 + dT2;

            eta = qpp/(qpp + sigma*epsilon*(T^4-T_inf^4) + h_nat*(T-T_inf));

            L = C_1/v_max^2;

            N_L=L/S_L;

            A_cs = w*H/2;

            A_hs = w*(N_L*S_L);
            mdot2 = qpp*A_hs/dh;

            v = mdot/rho/A_cs;
        end
        function setS_L(c)
            c.S_L = c.P_L*c.D;
        end
        function setH(c)
            c.H = 4*(c.S_T-c.D);
        end
        function setA_min(c)
            c.A_min = (c.S_T-c.D)*c.H;
        end
        function setv_max(c)
            C_1 = ( 2*c.dp*c.S_L ) / ( CO2.density(c.T_av)*c.f );
            C_2 = ( rho*A_min*c.dh ) / ( w*c.qpp );
            
            c.v_max = (C_1/C_2)^(1/3);
        end
        function setmdot(c)
            c.mdot = c.qpp*c.A_hs/c.dh;
        end
        
        function setFluidProperties(c)
            c.rho_av = CO2.density(c.T_av);
            c.Pr_av  = CO2.prandtl(c.T_av);
            c.mu_av  = CO2.viscosity(c.T_av);
            c.k_f_av = CO2.conductivity(c.T_av);
        end
    end
    
end

