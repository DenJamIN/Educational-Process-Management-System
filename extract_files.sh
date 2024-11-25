#!/bin/bash

PROJECT_ROOT="${1:-.}"
PROJECT_ROOT="${PROJECT_ROOT%/}"

find "$PROJECT_ROOT" \
    \( -path "$PROJECT_ROOT/.idea" -o -path "$PROJECT_ROOT/.git" \) -prune -o \
    -type f \
    ! \( \
        -name 'mvnw' -o \
        -name 'mvnw.cmd' -o \
        -name 'README.md' -o \
        -name 'LICENSE' -o \
        -name '.gitignore' -o \
        -name '.gitattributes' \
    \) \
    -print0 | while IFS= read -r -d '' file; do
    rel_path="${file#"$PROJECT_ROOT"/}"
    echo "$rel_path"
    echo '```'
    cat "$file"
    echo
    echo '```'
    echo
done
