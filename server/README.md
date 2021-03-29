# Localsearch Server

Add localsearch to your `/etc/hosts` (Linux) or `C:\Windows\System32\drivers\etc\hosts` (Windows)

```
# Added by Localsearch
127.0.0.1       localsearch
127.0.0.1       www.localsearch
# End of section
```

## Firefox

### TBD

## Chrome

1. Go to [chrome://settings/searchEngines](chrome://settings/searchEngines)
2. Add (Search Engine, Keyword, URL with %s in place of query) = (localsearch, l, localsearch?q=%s)
    - For development localsearch, the URL should include the development port (Default to `8080`) 
3. Try it out, type `l` in the omnibar and press tab. You should see *"Search localsearch"*, suggestions should be there too.

## Edge (the new chromium based one)

See Chrome instructions. But go to [edge://settings/searchEngines](edge://settings/searchEngines)
