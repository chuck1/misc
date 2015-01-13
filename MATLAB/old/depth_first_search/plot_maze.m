function [  ] = plot_maze( f,w,ispath,unvisited,dead )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
    figure(f)
    clf
    disc_plot(ispath,'k')
    disc_plot(unvisited,'b')
    disc_plot(dead,'r')
    if w
        pause()
    else
        pause(0.01)
    end

end

