close all;clear all;clc

figure()
L = 0.7+11*0.9093;
for d=[0 L 2*L]
    rectangle('Position',[-0.35+d 0 L 5*0.35],'FaceColor',[0.5 0.5 1])
    rectangle('Position',[0+d     0 11*0.9093 4*0.35],'FaceColor',[1 1 1])
end

axis equal