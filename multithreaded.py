'''
Written by Ozkan Sener ozkansener@gmail.com
Maybe we need to add more characters 
Maybe we need to extend the length of the characters
'''


from multiprocessing.pool import ThreadPool
from urllib.request import urlopen

# cd "/Applications/Python 3.7/" 
# "./Install Certificates.command"
from itertools import product

chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890' # chars to look for
urls = []# list

for length in range(0, 15): # length of chars
    to_attempt = product(chars, repeat=length)
    for attempt in to_attempt:
        a=("https://"+''.join(attempt)+".nl")

        urls.append(a)

import sys
sys.stdout = open('nl.csv','wt')
def fetch_url(url):
    try:
        response = urlopen(url)
        return url, response.read(), None
    except Exception as e:
        return url, None, e

results = ThreadPool(4000).imap_unordered(fetch_url, urls)
for url, html, error in results:
    if error is None:
        print(url)
