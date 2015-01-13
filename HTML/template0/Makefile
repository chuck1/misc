
md_files   = $(shell find . -name '*.md')
html_files = $(patsubst ./pages/%.md, ./html/%.html, $(md_files))

all: $(html_files)
	@echo $(html_files)

html/%.html: pages/%.md
	@mkdir -p $(dir $@)
	@perl Markdown/Markdown.pl --html4tags $^ > $@


