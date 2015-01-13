close all

h=0.1;
L=0.4;
n=L/h;
for i=0:n-1
    plot([0 L],[i*h i*h]);hold on
    plot([0 L],[(i+0.5)*h (i+0.5)*h],'--')
    plot([i*h i*h],[0 L]);
    plot([(i+0.5)*h (i+0.5)*h],[0 L],'--')
    if i==1 || i==n-1
        h1=plot([h L-h],[i*h i*h]);hold on
        h2=plot([i*h i*h],[h L-h]);
        set(h1,'LineWidth',2)
        set(h2,'LineWidth',2)
    end
end
plot([0 L],[n*h n*h])
plot([n*h n*h],[0 L])
scatter([0.05 0.05 0.1],[0.05 0.1 0.05],'b')
text(0.05+0.005,0.05+0.005,'1,1','VerticalAlignment','bottom')
text(0.1+0.005,0.05+0.005,'1,1','VerticalAlignment','bottom')
text(0.05+0.005,0.1+0.005,'1,1','VerticalAlignment','bottom')

print -dpdf 1.pdf