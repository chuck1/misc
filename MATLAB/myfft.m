function [F,Y] = myfft(f,y1,y2,n)

NFFT = 2^(nextpow2(length(y1))-n);
Y1 = fft(y1,NFFT);
Y2 = fft(y2,NFFT);
%Y = Y/length(y);

Y1 = Y1(1:length(Y1)/2);
Y2 = Y2(1:length(Y2)/2);
Y = Y1.*conj(Y2);

F = linspace(0,f/2,NFFT/2)';